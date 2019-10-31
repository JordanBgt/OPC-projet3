import java.io.IOException;
import java.util.Properties;

/**
 * <b>Enum singleton ApplicationProperties</b>
 *
 * To read application.properties file
 */
public enum ApplicationProperties {

    INSTANCE;

    private final Properties properties;

    /**
     * properties => list of properties
     * properties.load => read a propertiy list
     * getRessourceAsStream => returns an input stream for reading the specified file
     */
    ApplicationProperties(){
        properties = new Properties();
        try{
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e){
            // TODO : logger l'exception
        }
    }

    /**
     * @return tryoutNumber property
     */
    public Integer getPropertyTryoutNumber(){
        return Integer.parseInt(properties.getProperty("tryoutNumber"));
    }

    /**
     * @return devMode property
     */
    public String getPropertyDevMode(){
        return properties.getProperty("devMode");
    }

    /**
     * @return totalCombinationNumber property
     */
    public Integer getPropertyCombinationSize(){
        return Integer.parseInt(properties.getProperty("combinationSize"));
    }

    /**
     * @return maxCombinationValue property
     */
    public Integer getPropertyMaxCombinationValue(){
        return Integer.parseInt(properties.getProperty("maxCombinationValue"));
    }

    /**
     * @return minCombinationValue property
     */
    public Integer getPropertyMinCombinationValue(){
        return Integer.parseInt(properties.getProperty("minCombinationValue"));
    }
}
