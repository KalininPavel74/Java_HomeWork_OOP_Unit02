package unit2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Competition {
    static Logger logger = Logger.getLogger(Competition.class.getName());
    public Competition() {

        // Инициализация Мобильных объектов
        Human champion = new Human("Чемпион",Util.symbol(128170),35,2);
        Human programmer = new Human("Программист",Util.symbol(129321),25,1);
        Cat barsic = new Cat("Барсик",Util.symbol(128008),10,1);
        Cat catInBoots = new Cat("Кот в сапогах",Util.symbol(128098),30,4);
        Robot termitatorT800 = new Robot("Терминатор Т-800",Util.symbol(128128),15,2);
        Robot termitatorT1000 = new Robot("Терминатор Т-1000",Util.symbol(129338),40,3);
        Robot R2D2 = new Robot("R2D2",Util.symbol(129469),15,0);
        int qtyMobile = 7;
        IMobileObject[] mobileObjects = new IMobileObject[qtyMobile];
        int i=0;
        mobileObjects[i++] = champion;
        mobileObjects[i++] = programmer;
        mobileObjects[i++] = barsic;
        mobileObjects[i++] = catInBoots;
        mobileObjects[i++] = termitatorT800;
        mobileObjects[i++] = termitatorT1000;
        mobileObjects[i++] = R2D2;

        // Иницилизация Препятствий
        String scooter = Util.symbol(128756);
        Treadmill treadmill10 = new Treadmill("Беговая дорожка 10 км/ч",scooter,10);
        Treadmill treadmill20 = new Treadmill("Беговая дорожка 20 км/ч",scooter+scooter,20);
        Treadmill treadmill30 = new Treadmill("Беговая дорожка 30 км/ч",scooter+scooter+scooter,30);
        Wall wall1 = new Wall("Барьер (1м)",Util.symbol(128679),1);
        Wall wall2 = new Wall("Кактус (2м)",Util.symbol(127883),2);
        Wall wall3 = new Wall("Пальма (3м)",Util.symbol(127796),3);
        int qtyObstacle = 6;
        AObstacle[] obstacles = new AObstacle[qtyObstacle];
        i=0;
        obstacles[i++] = treadmill10;
        obstacles[i++] = wall1;
        obstacles[i++] = treadmill20;
        obstacles[i++] = wall2;
        obstacles[i++] = treadmill30;
        obstacles[i++] = wall3;

        // данные для фотофиниша
        Map<IMobileObject, StringBuilder> fotofinish = new HashMap<IMobileObject, StringBuilder>();
        for(IMobileObject m: mobileObjects)
            fotofinish.put(m, new StringBuilder());
        for(IMobileObject m: mobileObjects)
            fotofinish.get(m).append(m.getSymbol()).append("     | ");

        logger.warning("Соревнование на полосе препядствий. "+Util.symbol(127942));
        StringBuilder sb = new StringBuilder();
        for(IMobileObject m: mobileObjects)
            sb.append(m.getName()).append(m.getSymbol()).append("; ");
        logger.warning("Участники: "+sb);
        logger.warning("");
        logger.warning("START");
        logger.warning("");
        ArrayList<IMobileObject> winners = new ArrayList<IMobileObject>();
        winners.addAll(List.of(mobileObjects));
        ArrayList<IMobileObject> tempWinners = new ArrayList<IMobileObject>();
        for(AObstacle o: obstacles) {
            for(IMobileObject w: winners) {
                logger.warning(String.format("К препядствию %s%s подошел %s%s.",o.getName(),o.getSymbol(),w.getName(),w.getSymbol()));
                boolean success = false;
                try { success = o.overcome(w);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    logger.warning("Разрешено обойти препятствие.");
                    continue;
                }
                if(success) {
                    logger.warning(String.format("%s%s %s"
                            ,w.getName(),w.getSymbol(),o.getLuckMessage(),Util.symbol(127773)));
                    tempWinners.add(w);
                    fotofinish.get(w).append(" - ").append(o.getSymbol());
                } else {
                    logger.warning(String.format("%s%s %s %s"
                            ,w.getName(),w.getSymbol(),o.getFallMessage(),Util.symbol(10060))); //"\u267f" 9855
                    fotofinish.get(w).append(" - ").append(o.getSymbol()).append(Util.symbol(10060));
                }

            }
            winners = tempWinners;
            tempWinners = new ArrayList<IMobileObject>();
        }
        logger.warning("");
        logger.warning("FINISH");
        logger.warning("");

        sb = new StringBuilder();
        for(IMobileObject w: winners)
            sb.append(w.getName()).append(w.getSymbol()).append("; ");
        logger.warning("Победители соревнования "+Util.symbol(128081)+": "+sb);
        logger.warning("");
        for(IMobileObject w: winners)
            fotofinish.get(w).append("    ").append(Util.symbol(129351));
        logger.warning("Фотофиниш "+Util.symbol(129351)+Util.symbol(129352)+Util.symbol(129353));
        logger.warning("");
        for(IMobileObject m: mobileObjects) {
            logger.warning(fotofinish.get(m).toString());
        }
    }
}
