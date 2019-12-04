package net.endoedgar;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Head extends SimpleTagSupport {
    private String thecolor;
    private String words;
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if(thecolor != null)
            out.write(String.format("<span style='color:%s'>%s</span>", thecolor, words));
        else
            out.write(String.format("<span>%s</span>", words));
    }
    
    public void setThecolor(String thecolor) {
        this.thecolor = thecolor;
    }
    
    public void setWords(String words) {
        this.words = words;
    }
}
