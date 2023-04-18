package libs;


import org.aeonbits.owner.Config;

@Config.Sources(value = "file:./src/main/java/properties/Links.properties")
public interface LinksProperties extends Config {
    String UKRAINE();
    String UK();
    String USA();
    String POLAND();
    String KAZAKHSTAN();
}
