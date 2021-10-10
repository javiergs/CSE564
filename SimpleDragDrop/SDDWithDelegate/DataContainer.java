import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataContainer {

    private static DataContainer instance;
    private List<City> cityList = new ArrayList<>();

    protected DataContainer() {}

    public static DataContainer getInstance() {
        if (instance == null) {
            instance = new DataContainer();
        }
        return instance;
    }
 
    public void add (City city) {
        cityList.add(city);
    }
    
    public City get (int index) {
        return cityList.get(index);
    }
    
    public int size () {
        return cityList.size();
    }
    
    public void clear() {
        cityList.clear();
    }
    
    public int[] travelingOrder() {
        Set<Integer> visited = new HashSet<>();
        int[] order = new int[cityList.size()];
        int size=cityList.size();
        int currentIndex = 0;
        while(visited.size() < cityList.size()){
            order[visited.size()] = currentIndex;
            City currentCity = cityList.get(currentIndex);
            double minDistance = Double.POSITIVE_INFINITY;
            int minDistanceIndex = -1;
            for(int j=0;j<size;j++){
                if (!visited.contains(j)) {
                    double distance = Math.hypot(
                            Math.abs(
                              cityList.get(j).getX() - currentCity.getX()),
                            Math.abs(
                              cityList.get(j).getY() - currentCity.getY())
                    );
                    if (distance < minDistance) {
                        minDistanceIndex = j;
                        minDistance = distance;
                    }
                }
            }
            visited.add(currentIndex);
            currentIndex = minDistanceIndex;
        }
        return order;
    }
    
    public void saveToFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("NAME: userCreated" + cityList.size() + "\n");
        sb.append("COMMENT: " + cityList.size() + " locations" + "\n");
        sb.append("COMMENT: created by the user" + "\n");
        sb.append("TYPE: TSP" + "\n");
        sb.append("DIMENSION: " + cityList.size() + "\n");
        sb.append("EDGE_WEIGHT_TYPE : EUC_2D" + "\n");
        sb.append("NODE_COORD_SECTION" + "\n");
        for (int i = 0; i < cityList.size(); i++) {
            sb.append("" + (i + 1) + " " +
                    cityList.get(i).getX() + " " +
                    cityList.get(i).getY() + " " +
                    cityList.get(i).getLabel() + "\n");
        }
        sb.append("EOF");
        FileOutputStream saveFile = new FileOutputStream(path);
        ObjectOutputStream saveObject = new ObjectOutputStream(saveFile);
        saveObject.writeBytes(sb.toString());
        saveObject.close();
    }
    
    public void readFile(String path) throws IOException {
        cityList.clear();
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        boolean started = false;
        while ((str = br.readLine()) != null) {
            if (str.startsWith("1")) {
                started = true;
            } else if (str.startsWith("EOF")) {
                return;
            }
            if (started) {
                String[] data = str.split(" ");
                int x = Integer.parseInt(data[1].trim());
                int y = Integer.parseInt(data[2].trim());
                String label = data[3];
                cityList.add(new City(label, x, y));
            }
        }
    }
    
}
