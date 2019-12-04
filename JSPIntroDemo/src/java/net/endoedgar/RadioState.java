package net.endoedgar;

public final class RadioState {
    private String yesCheck;
    private String noCheck;

    public RadioState() {
        this.setNone();
    }

    public void setYes() {
        this.yesCheck = "checked";
        this.noCheck = "";
    }

    public void setNo() {
        this.yesCheck = "";
        this.noCheck = "checked";
    }
    
    public void setNone() {
        this.yesCheck = this.noCheck = "";
    }

    public String getYesCheck() {
        return yesCheck;
    }

    public String getNoCheck() {
        return noCheck;
    }
}
