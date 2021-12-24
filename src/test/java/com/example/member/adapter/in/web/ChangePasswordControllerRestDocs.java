package com.example.member.adapter.in.web;

import static com.example.member.utils.ApiDocumentUtils.getDocumentRequest;
import static com.example.member.utils.ApiDocumentUtils.getDocumentResponse;
import static com.example.member.utils.ResourceMockUtil.getString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.member.application.port.in.ChangePasswordUseCase;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith(RestDocumentationExtension.class)
@DisplayName("ChangePasswordController 클래스")
class ChangePasswordControllerRestDocs {

  @MockBean
  private ChangePasswordUseCase useCase;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp(final RestDocumentationContextProvider restDocumentation) throws NoSuchAlgorithmException {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .alwaysDo(MockMvcResultHandlers.print())
        .build();

    useCase = command -> {

    };
  }

  @Test
  @DisplayName("비밀번호 변경을 요청 합니다")
  public void authenticationApiTest() throws Exception {
    mockMvc.perform(
            put("/users")
                .contentType(APPLICATION_JSON)
                .content(getString("비밀번호변경.json"))
        ).andExpect(status().isOk())
        .andDo(document("user-change-password",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("id")
                    .type(JsonFieldType.NUMBER)
                    .description("아이디"),
                fieldWithPath("password")
                    .type(JsonFieldType.STRING)
                    .description("변경할 패스워드"),
                fieldWithPath("confirmPassword")
                    .type(JsonFieldType.STRING)
                    .description("변경할 패스워드 확인")
            )
        ));
  }

}
