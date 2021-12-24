package com.example.member.adapter.in.web;

import static com.example.member.utils.ApiDocumentUtils.getDocumentRequest;
import static com.example.member.utils.ApiDocumentUtils.getDocumentResponse;
import static com.example.member.utils.ResourceMockUtil.getString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.member.adapter.in.web.model.LoginResponse;
import com.example.member.application.port.in.LoginUseCase;
import java.security.NoSuchAlgorithmException;
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
@DisplayName("LoginController 클래스")
public class LoginControllerRestDocs {

  @MockBean
  private LoginUseCase useCase;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  private final static String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
      ".eyJpc3MiOiJteS1tZW1iZXItYXBpLXNlcnZpY2UiLCJpYXQiOjE2NDAyNzg5ODksImV4cCI6MTY0MDI4MDE4OSwic3ViIjoidXNlci1hdXRoIiwiaWQiOjEsImVtYWlsIjoiYWJjQGFiYy5jb20ifQ.hlpR4cRQNX0HhiG9ckvpTDWjTyhErEN-iunO9bwjIAw";

  @BeforeEach
  public void setUp(final RestDocumentationContextProvider restDocumentation) throws NoSuchAlgorithmException {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .build();

    init();
  }

  public void init() throws NoSuchAlgorithmException {
    given(useCase.login(any(), any()))
        .willReturn(new LoginResponse(TOKEN));
  }


  @Test
  @DisplayName("로그인을 요청 하면 토큰이 발행됩니다.")
  public void authenticationApiTest() throws Exception {
    mockMvc.perform(
            post("/login")
                .contentType(APPLICATION_JSON)
                .content(getString("로그인.json"))
        ).andExpect(status().isOk())
        .andDo(document("user-login",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("email")
                    .type(JsonFieldType.STRING)
                    .description("이메일"),
                fieldWithPath("password")
                    .type(JsonFieldType.STRING)
                    .description("패스워드")
            ),
            responseFields(
                fieldWithPath("token")
                    .type(JsonFieldType.STRING)
                    .description("토큰")
            )
        ));
  }


}
