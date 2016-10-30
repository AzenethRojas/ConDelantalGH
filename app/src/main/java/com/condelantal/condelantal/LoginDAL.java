package com.condelantal.condelantal;

/**
 * Created by Azeneth Rojas on 29/10/2016.
 */

import java.io.IOException;
import java.lang.reflect.Type;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class LoginDAL {

    public int consultarUsuario(String nombre, String contrasena)
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "consultarUsuario";
        SoapObject request = new SoapObject("ConDelantal", "consultarUsuario");
        request.addProperty("nombre",nombre);
        request.addProperty("contrasena",contrasena);
        String respuesta = "";

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try
        {
            HttpTransportSE androidHttpTransport = new HttpTransportSE("");
            androidHttpTransport.call(SOAP_ACTION, envelope);

            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            Gson gson = new Gson();
            respuesta = gson.fromJson(response.toString(), type);
        }
        catch(IOException | XmlPullParserException | JsonParseException ex)
        {
            ex.toString();
        }

        return Integer.parseInt(respuesta);
    }

}
