package com.springApp.dao;

import com.springApp.TestEntity;
import com.springApp.model.Settlement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UniversalImpTest {

    @InjectMocks
    private UniversalImp dao;

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @BeforeEach
    void setUp() {
        when(factory.getCurrentSession()).thenReturn(session);
    }

    /**
     * Тестирование универсального метода add, который принимает объект сущности и сохраняет его
     */
    @Test
    void addTest() {
        // Arrange
        Settlement testSettlement = new TestEntity().getTestSettlement();

        // Act
        dao.add(testSettlement);

        // Assert
        verify(session).save(testSettlement);
    }
}
