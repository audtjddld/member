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

import com.example.member.adapter.in.web.model.AuthenticateMobileResponse;
import com.example.member.application.port.in.AuthenticateMobileUseCase;
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
@DisplayName("AuthenticationMobileController 클래스")
class AuthenticationMobileControllerDocs {

  @MockBean
  private AuthenticateMobileUseCase useCase;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp(final RestDocumentationContextProvider restDocumentation) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .apply(documentationConfiguration(restDocumentation))
        .build();

    init();
  }

  public void init() {
    given(useCase.authenticate(any()))
        .willReturn(new AuthenticateMobileResponse("123456"));
  }

  @Test
  @DisplayName("인증번호 요청을 접수받습니다")
  public void authenticationApiTest() throws Exception {
    mockMvc.perform(
            post("/authentications")
                .contentType(APPLICATION_JSON)
                .content(getString("인증요청.json"))
        ).andExpect(status().isOk())
        .andDo(document("authentications",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("mobile")
                    .type(JsonFieldType.STRING)
                    .description("전화번호")
            ),
            responseFields(
                fieldWithPath("authenticationNumber")
                    .type(JsonFieldType.STRING)
                    .description("인증번호")
            )

        ));
  }

}
