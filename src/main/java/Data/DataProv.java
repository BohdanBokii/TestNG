package Data;

import org.testng.annotations.DataProvider;

public class DataProv {
    @DataProvider
    public Object[][] dataFormConsult() {
        return new Object[][] {
                {"Alfred","goodguy02@onlinecmail.com","697214869","vb","Python Pro"},
                {"Bryanna","2529460500@hieu.in","678739167","tg","Project Management"},
                {"Johnny","dmozguy@stackinglayers.com","638549275","tg","Java Pro"},
                {"Lisa","sargsiansarg@cggup.com","669148566","tg","QA Automation"},
                {"Paulina","cfalco@bukan.es","975999458","vb","SMM Pro"},
        };
    }
}
