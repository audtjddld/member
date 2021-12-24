package com.example.member.adapter.in.web;

import static com.example.member.utils.ApiDocumentUtils.getDocumentRequest;
import static com.example.member.utils.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.member.application.port.in.UserProfileUseCase;
import com.example.member.application.port.in.command.UserProfileResponse;
import com.example.member.config.interceptor.AuthorizationInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith(RestDocumentationExtension.class)
@DisplayName("UserProfileController 클래스")
class UserProfileControllerRestDocs {

  @MockBean
  private AuthorizationInterceptor authorizationInterceptor;

  @MockBean
  private UserProfileUseCase useCase;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  private final static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
      ".eyJpc3MiOiJteS1tZW1iZXItYXBpLXNlcnZpY2UiLCJpYXQiOjE2NDAyNzg5ODksImV4cCI6MTY0MDI4MDE4OSwic3ViIjoidXNlci1hdXRoIiwiaWQiOjEsImVtYWlsIjoiYWJjQGFiYy5jb20ifQ.hlpR4cRQNX0HhiG9ckvpTDWjTyhErEN-iunO9bwjIAw";

  @BeforeEach
  public void setUp(final RestDocumentationContextProvider restDocumentation) throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .build();

    init();
  }

  public void init() throws Exception {
    final UserProfileResponse userProfileResponse = UserProfileResponse.builder()
        .nickname("abc")
        .name("홍길동")
        .mobile("010-1234-5678")
        .email("abc@abc.com")
        .build();

    given(useCase.profile(any()))
        .willReturn(userProfileResponse);

    given(authorizationInterceptor.preHandle(any(), any(), any()))
        .willReturn(true);
  }


  @Test
  @DisplayName("사용자 프로파일을 요청하면, 사용자 정보를 리턴한다.")
  public void authenticationApiTest() throws Exception {
    mockMvc.perform(
            get("/profile/{id}", 1)
                .contentType(APPLICATION_JSON)
                .header("Authorization", "Bearer " + TOKEN)
        ).andExpect(status().isOk())
        .andDo(document("user-profile",
            getDocumentRequest(),
            getDocumentResponse(),
            pathParameters(
                parameterWithName("id")
                    .description("아이디")
            ),
            responseFields(
                fieldWithPath("email")
                    .type(JsonFieldType.STRING)
                    .description("이메일"),
                fieldWithPath("nickname")
                    .type(JsonFieldType.STRING)
                    .description("닉네임"),
                fieldWithPath("name")
                    .type(JsonFieldType.STRING)
                    .description("이름"),
                fieldWithPath("mobile")
                    .type(JsonFieldType.STRING)
                    .description("휴대번호")
            )
        ));
  }

}
