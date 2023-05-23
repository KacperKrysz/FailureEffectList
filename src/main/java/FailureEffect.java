class FailureEffectOb {

    int failureEffectId;
    String FailureEffect;
    String Failure;

    public String getFailureEffect() {
        return FailureEffect;
    }

    public void setFailureEffect(String failureEffect) {
        FailureEffect = failureEffect;
    }

    public String getFailure() {
        return Failure;
    }

    public void setFailure(String failure) {
        Failure = failure;
    }

    public FailureEffectOb(int failureEffectId, String failureEffect) {
        this.failureEffectId = failureEffectId;
        FailureEffect = failureEffect;
    }

    @Override
    public String toString() {
        return "FailureEffectOb{" +
                "failureEffectId=" + failureEffectId +
                ", FailureEffect='" + FailureEffect + '\'' +
                '}';
    }
}
