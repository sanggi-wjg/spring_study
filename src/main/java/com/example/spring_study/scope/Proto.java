package com.example.spring_study.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Proto {

    /*
    * proxyMode 를 사용해서 싱글톤 객체에서 proto type 객체를 생성 해도 모두 다른 인스턴스를 가질수 있다.
    *
    * */

}
