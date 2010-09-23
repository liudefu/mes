package com.qcadoo.mes.core.data.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qcadoo.mes.core.data.DataAccessTest;
import com.qcadoo.mes.core.search.Restrictions;
import com.qcadoo.mes.core.search.SearchCriteria;

public final class SearchCriteriaBuilderTest extends DataAccessTest {

    @Test
    public void shouldCreateCriteriaWithDefaults() throws Exception {
        // when
        SearchCriteria searchCriteria = (SearchCriteria) dataDefinition.find();

        // then
        assertEquals(0, searchCriteria.getFirstResult());
        assertEquals(25, searchCriteria.getMaxResults());
        assertEquals(dataDefinition, searchCriteria.getDataDefinition());
        assertNull(searchCriteria.getGridDefinition());
        assertEquals("id", searchCriteria.getOrder().getFieldName());
        assertTrue(searchCriteria.getOrder().isAsc());
        assertTrue(searchCriteria.getRestrictions().isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrownAnExceptionIfThereIsTooManyRestrictions() throws Exception {
        // when
        dataDefinition.find().restrictedWith(Restrictions.eq(fieldDefinitionAge, 5))
                .restrictedWith(Restrictions.eq(fieldDefinitionName, "asb%"))
                .restrictedWith(Restrictions.eq(fieldDefinitionName, "asd%"))
                .restrictedWith(Restrictions.eq(fieldDefinitionName, "asw%"))
                .restrictedWith(Restrictions.eq(fieldDefinitionName, "asg%"))
                .restrictedWith(Restrictions.eq(fieldDefinitionName, "asu%"));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrownAnExceptionIfOrderIsNull() throws Exception {
        // when
        dataDefinition.find().orderBy(null);
    }

}
