package website.automate.waml.io.model;

import static org.junit.Assert.assertTrue;
import static website.automate.waml.io.model.ActionType.isExplicit;
import static website.automate.waml.io.model.ActionType.isImplicit;

import org.junit.Test;

import website.automate.waml.io.model.action.ClickAction;
import website.automate.waml.io.model.action.EnsureAction;
import website.automate.waml.io.model.action.EnterAction;
import website.automate.waml.io.model.action.IncludeAction;
import website.automate.waml.io.model.action.MoveAction;
import website.automate.waml.io.model.action.OpenAction;
import website.automate.waml.io.model.action.StoreAction;
import website.automate.waml.io.model.action.WaitAction;

public class ActionTypeTest {

    @Test
    public void clickActionIsExplicit(){
        assertTrue(isExplicit(ClickAction.class));
    }
    
    @Test
    public void moveActionIsExplicit(){
        assertTrue(isExplicit(MoveAction.class));
    }
    
    @Test
    public void enterActionIsExplicit(){
        assertTrue(isExplicit(EnterAction.class));
    }
    
    @Test
    public void openActionIsExplicit(){
        assertTrue(isExplicit(OpenAction.class));
    }
    
    @Test
    public void waitActionIsExplicit(){
        assertTrue(isExplicit(WaitAction.class));
    }
    
    @Test
    public void storeActionIsImplicit(){
        assertTrue(isImplicit(StoreAction.class));
    }
    
    @Test
    public void ensureActionIsImplicit(){
        assertTrue(isExplicit(EnsureAction.class));
    }
    
    @Test
    public void includeActionIsImplicit(){
        assertTrue(isImplicit(IncludeAction.class));
    }
}
