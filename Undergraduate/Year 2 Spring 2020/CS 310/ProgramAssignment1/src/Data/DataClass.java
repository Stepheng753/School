package Data;

public class DataClass {

    private String dataName;
    private int dataInt;

    public DataClass (String dataName, int dataInt) {
        setDataName(dataName);
        setDataInt(dataInt);
    }

    public void setDataName (String dataName) {
        this.dataName = dataName;
    }

    public String getDataName () {
        return dataName;
    }

    public void setDataInt (int dataInt) {
        this.dataInt = dataInt;
    }

    public int getDataInt() {
        return dataInt;
    }

    @Override
    public String toString () {

        String dataDisplay = "Data Name: ".concat(getDataName());
        int currentLength = dataDisplay.length();
        for (int i = currentLength; i < 25; i++) {
            dataDisplay = dataDisplay.concat("\u0020");
        }
        dataDisplay = dataDisplay.concat("Data Int: ").concat(String.valueOf(getDataInt()) );
        return dataDisplay;
    }
}
