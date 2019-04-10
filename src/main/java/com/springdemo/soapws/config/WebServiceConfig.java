package com.springdemo.soapws.config;

import com.springdemo.soapws.constants.ApiConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter
{
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }


    @Bean(name = "book")
    public DefaultWsdl11Definition defaultWsdl11DefinitionForBook(XsdSchema caseSchema)
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BookPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(ApiConstants.NAMESPACE_URI);
        wsdl11Definition.setSchema(caseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema caseSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("book.xsd"));
    }


    @Bean(name = "author")
    public DefaultWsdl11Definition defaultWsdl11DefinitionForAuthor(XsdSchema authorSchema)
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AuthorPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(ApiConstants.NAMESPACE_URI);
        wsdl11Definition.setSchema(authorSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema authorSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("author.xsd"));
    }
}
