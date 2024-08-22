module com.example.jmp.cloud.service.impl {
    requires transitive com.example.jmp.service.api;
    requires com.example.jmp.dto;

    exports com.example.jmp.cloud.service.implementation;

    provides com.example.jmp.service.api.Service with com.example.jmp.cloud.service.impl.ServiceImplementation;
}
