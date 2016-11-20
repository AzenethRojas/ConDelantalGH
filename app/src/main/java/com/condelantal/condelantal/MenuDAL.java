package com.condelantal.condelantal;

/**
 * Created by Azeneth Rojas on 13/11/2016.
 */
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class MenuDAL {

    public ArrayList<Menu> consultarMenu()
    {
        Type typeLst = new TypeToken<ArrayList<Menu>>(){}.getType();
        ArrayList<Menu> lstMenu = new ArrayList<Menu>();
        String SOAP_ACTION = "ConDelantal" + "/" + "consultarMenu";
        SoapObject request = new SoapObject("ConDelantal", "consultarMenu");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try
        {
            HttpTransportSE androidHttpTransport = new HttpTransportSE("http://azenethrojas-001-site1.btempurl.com/WSRestaurante.asmx");
            androidHttpTransport.call(SOAP_ACTION, envelope);

            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            Gson gson = new Gson();
            lstMenu = gson.fromJson(response.toString(), typeLst);
        }
        catch(IOException | XmlPullParserException | JsonParseException ex)
        {
            ex.toString();
        }

        return lstMenu;

    }
}
