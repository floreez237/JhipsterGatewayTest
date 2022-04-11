package com.myapp.service;

import static org.junit.jupiter.api.Assertions.*;

import com.myapp.domain.A;
import com.myapp.repository.ARepository;
import com.myapp.service.dto.ADTO;
import com.myapp.service.mapper.AMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class AServiceTest {

    @Mock
    private ARepository aRepository;

    private final AMapper aMapper = Mappers.getMapper(AMapper.class);
    private AService aService;

    @BeforeEach
    void setUp() {
        //        MockitoAnnotations.openMocks(this);
        aService = new AService(aRepository, aMapper);
    }

    @Test
    void save() {
        ADTO adto = new ADTO();
        A savedA = new A();
        savedA.setId(1L);
        Mockito.when(aRepository.save(ArgumentMatchers.any(A.class))).thenReturn(Mono.just(savedA));
        Mono<ADTO> setup = aService.save(adto);
        StepVerifier
            .create(setup)
            .assertNext(adto1 -> {
                assertNotNull(adto1.getId());
                assertEquals(1L, adto1.getId());
            })
            .verifyComplete();
    }

    @Test
    void partialUpdate() {}

    @Test
    void findAll() {}

    @Test
    void countAll() {}

    @Test
    void findOne() {}

    @Test
    void delete() {}
}
