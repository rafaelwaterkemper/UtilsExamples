import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;

public class PrintTransition {

    public static void main(String args[]) {
        //Print default Timezone in according with OS timezone
        //Ubuntu /etc/localtime
        System.out.println(java.util.TimeZone.getDefault().getID());
        
        //Show time in according with timezone default
        System.out.println(LocalDateTime.now());
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");

        ZoneRules rules = zoneId.getRules();

        LocalDate date = LocalDate.parse("2019-10-25");
        Instant instant = date.atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant();

        ZoneOffsetTransition nextTransition = rules.nextTransition(Instant.from(instant));

        System.out.println("Next transition at: " +
                nextTransition.getInstant().atZone(zoneId));

        ZoneOffsetTransition nextNextTransition =
                rules.nextTransition(nextTransition.getInstant());
        System.out.println("Next transition after that at: " +
                nextNextTransition.getInstant().atZone(zoneId));
    }
}
