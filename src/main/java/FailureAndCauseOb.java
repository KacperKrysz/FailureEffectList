import java.util.ArrayList;

public class FailureAndCauseOb {

    int idFC;
    String failure;
    ArrayList<String> causes;

    public int getIdFC() {
        return idFC;
    }

    public void setIdFC(int idFC) {
        this.idFC = idFC;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public ArrayList<String> getCauses() {
        return causes;
    }

    public void setCauses(ArrayList<String> causes) {
        this.causes = causes;
    }

    public FailureAndCauseOb(int idFC, String failure, ArrayList<String> causes) {
        this.idFC = idFC;
        this.failure = failure;
        this.causes = causes;
    }

    public FailureAndCauseOb(int idFC, String failure) {
        this.idFC = idFC;
        this.failure = failure;
    }

    @Override
    public String toString() {
        return "FailureAndCauseOb{" +
                "idFC=" + idFC +
                ", failure='" + failure + '\'' +
                ", causes=" + causes +
                '}';
    }
}
