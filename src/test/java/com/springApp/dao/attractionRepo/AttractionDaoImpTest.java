 package com.springApp.dao.attractionRepo;

import com.springApp.TestEntity;
import com.springApp.model.Attraction;
import com.springApp.model.Settlement;
import com.springApp.util.AttractionType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AttractionDaoImpTest {

    @InjectMocks
    private AttractionDaoImp dao;

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Query<Attraction> query;

    TestEntity testEntities = new TestEntity();
    List<Attraction> attractions = testEntities.getAttractions();
    Settlement testSettlement = testEntities.getTestSettlement();

    @BeforeEach
    void setUp() {
        when(factory.getCurrentSession()).thenReturn(session);
    }

    /**
     * Тестирование метода findByTypeSortByName (поиск по типу достопримечательности)
     */
    @Test
    void findByTypeSortByNameTest() {
        // Arrange
        when(session.createQuery(anyString(), eq(Attraction.class))).thenReturn(query);
        when(query.setParameter("type", AttractionType.MUSEUM)).thenReturn(query);
        when(query.list()).thenReturn(attractions);

        // Act
        List<Attraction> museums = dao.findByTypeSortByName(AttractionType.MUSEUM);

        // Assert
        assertThat(museums).isNotEmpty();
        assertThat(museums.get(0).getId()).isEqualTo(123);
        assertThat(museums.get(0).getName()).isEqualTo("TestName");
        assertThat(museums.get(0).getCreationDate()).isEqualTo("2020-10-10");
        assertThat(museums.get(0).getAboutAttraction()).isEqualTo("TestDescription");
        assertThat(museums.get(0).getSettlement()).isNotNull();
        assertThat(museums.get(0).getServiceOption()).isNotNull();
    }

    /**
     * Тестирование метода findBySettlementNameTest (поиск достопримечательностей по городу)
     */
    @Test
    void findBySettlementNameTest() {
        // Arrange
        when(session.createQuery(anyString(), eq(Attraction.class))).thenReturn(query);
        when(query.setParameter("settlementName", "TestSettlement")).thenReturn(query);
        when(query.list()).thenReturn(attractions);

        // Act
        List<Attraction> museums = dao.findBySettlementName(testSettlement.getName());

        // Assert
        assertThat(museums).isNotEmpty();
        assertThat(museums.get(0).getId()).isEqualTo(123);
        assertThat(museums.get(0).getName()).isEqualTo("TestName");
        assertThat(museums.get(0).getCreationDate()).isEqualTo("2020-10-10");
        assertThat(museums.get(0).getAboutAttraction()).isEqualTo("TestDescription");
        assertThat(museums.get(0).getSettlement()).isNotNull();
        assertThat(museums.get(0).getServiceOption()).isNotNull();
    }

    /**
     * Тестирование метода update (обновление описания достопримечательности)
     */
    @Test
    void updateTest() {
        // Arrange
        when(session.createQuery(anyString())).thenReturn(query);
        when(query.setParameter("description", "UpdatedDescription")).thenReturn(query);
        when(query.setParameter("id", 123)).thenReturn(query);
        when(query.executeUpdate()).thenReturn(1);

        // Act
        dao.update(123,"UpdatedDescription");

        // Assert
        verify(query).executeUpdate();
    }

    /**
     * Тестирование метода remove (удаление достопримечательности)
     */
    @Test
    void removeTest() {
        // Arrange
        when(session.createQuery(anyString())).thenReturn(query);
        when(query.setParameter("id", 123)).thenReturn(query);
        when(query.executeUpdate()).thenReturn(1);

        // Act
        dao.remove(123);

        // Assert
        verify(query).executeUpdate();
    }
}
