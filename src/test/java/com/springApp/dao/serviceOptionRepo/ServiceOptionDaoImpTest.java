package com.springApp.dao.serviceOptionRepo;

import com.springApp.TestEntity;
import com.springApp.model.ServiceOption;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceOptionDaoImpTest {

    @InjectMocks
    private ServiceOptionDaoImp dao;

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Query<ServiceOption> query;

    TestEntity testEntities = new TestEntity();
    ServiceOption serviceOption = testEntities.getTestServiceOption();

    @BeforeEach
    void setUp() {
        when(factory.getCurrentSession()).thenReturn(session);
    }

    /**
     * Тестирование метода testGetByType (получение объекта ServiceOption по его названию)
     */
    @Test
    void testGetByTypeTest() {
        // Arrange
        when(session.createQuery(anyString(), eq(ServiceOption.class))).thenReturn(query);
        when(query.setParameter("serviceOptionType", serviceOption.getName())).thenReturn(query);
        when(query.uniqueResult()).thenReturn(serviceOption);

        // Act
        ServiceOption result = dao.getByType(serviceOption.getName().toString());

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(serviceOption);
    }
}
