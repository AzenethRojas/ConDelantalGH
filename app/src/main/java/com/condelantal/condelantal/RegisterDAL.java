package com.condelantal.condelantal;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by Azeneth Rojas on 12/11/2016.
 */

public class RegisterDAL {
    public int insertarCliente(String nombre,String celular,String correo, String contrasena,int usuario)
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "insertarCliente";
        SoapObject request = new SoapObject("ConDelantal", "insertarCliente");
        request.addProperty("nombre",nombre);
        request.addProperty("celular",celular);
        request.addProperty("correo",correo);
        request.addProperty("contrasena",contrasena);
        request.addProperty("idUsuario",usuario);
        String respuesta = "";

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try
        {
            HttpTransportSE androidHttpTransport = new HttpTransportSE("http://azenethrojas-001-site1.btempurl.com/WSRestaurante.asmx");
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
    public int insertarUsuarioCliente(String nombre, String contrasena)
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "insertarUsuarioCliente";
        SoapObject request = new SoapObject("ConDelantal", "insertarUsuarioCliente");
        request.addProperty("nombre",nombre);
        request.addProperty("contrasena",contrasena);
        String respuesta = "";

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try
        {
            HttpTransportSE androidHttpTransport = new HttpTransportSE("http://azenethrojas-001-site1.btempurl.com/WSRestaurante.asmx");
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
    public int consultarCliente(String correo)
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "consultarCliente";
        SoapObject request = new SoapObject("ConDelantal", "consultarCliente");
        request.addProperty("correo",correo);
        String respuesta = "";

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try
        {
            HttpTransportSE androidHttpTransport = new HttpTransportSE("http://azenethrojas-001-site1.btempurl.com/WSRestaurante.asmx");
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
    public int consultarUsuario(String userName)
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "consultarUserName";
        SoapObject request = new SoapObject("ConDelantal", "consultarUserName");
        request.addProperty("nombre",userName);
        String respuesta = "";

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try
        {
            HttpTransportSE androidHttpTransport = new HttpTransportSE("http://azenethrojas-001-site1.btempurl.com/WSRestaurante.asmx");
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
    public int consultarClienteId(String nombre, String contrasena)
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "consultarClienteId";
        SoapObject request = new SoapObject("ConDelantal", "consultarClienteId");
        request.addProperty("nombre",nombre);
        request.addProperty("contrasena",contrasena);
        String respuesta = "";

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try
        {
            HttpTransportSE androidHttpTransport = new HttpTransportSE("http://azenethrojas-001-site1.btempurl.com/WSRestaurante.asmx");
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
