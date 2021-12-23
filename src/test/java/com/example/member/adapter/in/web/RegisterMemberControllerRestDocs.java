package com.example.member.adapter.in.web;

import static com.example.member.utils.ApiDocumentUtils.getDocumentRequest;
import static com.example.member.utils.ApiDocumentUtils.getDocumentResponse;
import static com.example.member.utils.ResourceMockUtil.getString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.member.application.port.in.RegisterMemberUseCase;
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
@DisplayName("RegisterMemberController 클래스")
class RegisterMemberControllerRestDocs {

  @MockBean
  private RegisterMemberUseCase useCase;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp(final RestDocumentationContextProvider restDocumentation) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .build();

    useCase = command -> {

    };
  }

  @Test
  @DisplayName("회원 가입을 요청 합니다")
  public void authenticationApiTest() throws Exception {
    mockMvc.perform(
            post("/members")
                .contentType(APPLICATION_JSON)
                .content(getString("회원가입.json"))
        ).andExpect(status().isCreated())
        .andDo(document("member-join",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("email")
                    .type(JsonFieldType.STRING)
                    .description("이메일"),
                fieldWithPath("mobile")
                    .type(JsonFieldType.STRING)
                    .description("전화번호"),
                fieldWithPath("name")
                    .type(JsonFieldType.STRING)
                    .description("성명"),
                fieldWithPath("nickname")
                    .type(JsonFieldType.STRING)
                    .description("닉네임"),
                fieldWithPath("password")
                    .type(JsonFieldType.STRING)
                    .description("패스워드")
            )
        ));
  }

}
