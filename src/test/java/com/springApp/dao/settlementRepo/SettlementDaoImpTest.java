package com.springApp.dao.settlementRepo;

import com.springApp.TestEntity;
import com.springApp.model.Settlement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SettlementDaoImpTest {

    @InjectMocks
    private SettlementDaoImp dao;

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Query<Settlement> query;

    TestEntity testEntities = new TestEntity();
    Settlement testSettlement = testEntities.getTestSettlement();

    @BeforeEach
    void setUp() {
        when(factory.getCurrentSession()).thenReturn(session);
        when(session.createQuery(anyString())).thenReturn(query);
    }

    /**
     * Тестирование метода getByName (поиск объекта Settlement по названию)
     */
    @Test
    void getByNameTest() {
        // Arrange
        when(query.setParameter("name", testSettlement.getName())).thenReturn(query);
        when(query.uniqueResult()).thenReturn(testSettlement);

        // Act
        Settlement result = dao.getByName(testSettlement.getName());

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(testSettlement);
    }

    /**
     *Тестирование метода updateMetro (изменение boolean-значения наличия метро в объекте города)
     */
    @Test
    void updateMetroTest() {
        // Arrange
        when(query.setParameter("id", testSettlement.getId())).thenReturn(query);
        when(query.setParameter("hasMetroUpd", true)).thenReturn(query);
        when(query.executeUpdate()).thenReturn(1);

        // Act
        dao.updateMetro(testSettlement.getId(), testSettlement.isHasMetro());

        // Assert
        verify(query).executeUpdate();
        assertThat(testSettlement.isHasMetro()).isTrue();
    }

    /**
     * Тестирование метода update (изменение данных о населении в городе)
     */
    @Test
    void updateTest() {
        // Arrange
        when(query.setParameter("id", testSettlement.getId())).thenReturn(query);
        when(query.setParameter("newPopulation", 100)).thenReturn(query);
        when(query.executeUpdate()).thenReturn(1);

        // Act
        dao.update(testSettlement.getId(), 100);

        // Assert
        verify(query).executeUpdate();
        assertThat(testSettlement.getPopulation()).isNotNegative();
    }
}
