import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
 
public class XmlToJsonModel {
    private String xmlText ;
    public XmlToJsonModel(String xml){
        this.xmlText = xml;
    }
    public String convertir(){
        try {
            JSONObject jsonObject = XML.toJSONObject(this.xmlText);
            return jsonObject.toString(4);
        } catch (JSONException e) {
            return "-1";
        }
    }
}
