package com.example.spring_study.global.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.validation.Errors;

import java.io.IOException;

@JsonComponent // Spring 에 Json Serializer 를 등록
public class ErrorsSerializer extends JsonSerializer<Errors> {
    /*
    * ObjectMapper 는 Errors class 를 serialize 할 때 이 class 를 사용
    * */

    @Override
    public void serialize(Errors errors, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        errors.getFieldErrors().forEach(e -> {
            try {
                gen.writeStartObject();
                gen.writeStringField("field", e.getField());
                gen.writeStringField("objectName", e.getObjectName());
                gen.writeStringField("code", e.getCode());
                gen.writeStringField("defaultMessage", e.getDefaultMessage());
                Object rejectedValue = e.getRejectedValue();
                if (rejectedValue != null) {
                    gen.writeStringField("rejectValue", rejectedValue.toString());
                }
                gen.writeEndObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        errors.getGlobalErrors().forEach(e -> {
            try {
                gen.writeStartObject();
                gen.writeStringField("objectName", e.getObjectName());
                gen.writeStringField("code", e.getCode());
                gen.writeStringField("defaultMessage", e.getDefaultMessage());
                gen.writeEndObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        gen.writeEndArray();
    }

}
