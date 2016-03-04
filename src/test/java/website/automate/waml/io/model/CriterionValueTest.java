package website.automate.waml.io.model;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CriterionValueTest {

    @Test
    public void valueConvertedToString(){
        CriterionValue value = new CriterionValue(1);
        
        assertThat(value.toString(), is("1"));
    }
    
    @Test
    public void valueConvertedToBoolean(){
        CriterionValue value = new CriterionValue(1);
        
        assertThat(value.toBoolean(), is(Boolean.FALSE));
    }
    
    @Test
    public void valueConvertedToLong(){
        CriterionValue value = new CriterionValue(1);
        
        assertThat(value.toLong(), is(1L));
    }
    
    @Test
    public void valueConvertedToInteger(){
        CriterionValue value = new CriterionValue("1");
        
        assertThat(value.toInteger(), is(1));
    }
    
    @Test
    public void valueConvertedToDouble(){
        CriterionValue value = new CriterionValue("1");
        
        assertThat(value.toDouble(), is(1.0));
    }
}
