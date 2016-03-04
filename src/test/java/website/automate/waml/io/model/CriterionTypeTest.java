package website.automate.waml.io.model;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CriterionTypeTest {

    @Test
    public void criterionTypeIsFound(){
        CriterionType criterionType = CriterionType.findByName("selector");
        
        assertThat(criterionType, is(criterionType));
    }
    
    @Test
    public void criterionTypeIsNotFound(){
        CriterionType criterionType = CriterionType.findByName("selector1");
        
        assertNull(criterionType);
    }
}
