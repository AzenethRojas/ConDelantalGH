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
import java.util.ArrayList;

/**
 * Created by Azeneth Rojas on 12/11/2016.
 */

public class ReservationDAL {
    public ArrayList<resumenReservacion> getAllReservations(int clientID)
    {
        Type typeLst = new TypeToken<ArrayList<resumenReservacion>>(){}.getType();
        ArrayList<resumenReservacion> lstresumen = new ArrayList<resumenReservacion>();
        String SOAP_ACTION = "ConDelantal" + "/" + "resumenReservacion";
        SoapObject request = new SoapObject("ConDelantal", "resumenReservacion");
        request.addProperty("idCliente",clientID);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try
        {
            HttpTransportSE androidHttpTransport = new HttpTransportSE("http://azenethrojas-001-site1.btempurl.com/WSRestaurante.asmx");
            androidHttpTransport.call(SOAP_ACTION, envelope);

            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            Gson gson = new Gson();
            lstresumen = gson.fromJson(response.toString(), typeLst);
        }
        catch(IOException | XmlPullParserException | JsonParseException ex)
        {
            ex.toString();
        }

        return lstresumen;

    }
    public ArrayList<Mesa> consultarMesas()
    {
        Type typeLst = new TypeToken<ArrayList<Mesa>>(){}.getType();
        ArrayList<Mesa> lstMesa = new ArrayList<Mesa>();
        String SOAP_ACTION = "ConDelantal" + "/" + "consultarMesas";
        SoapObject request = new SoapObject("ConDelantal", "consultarMesas");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        try
        {
            HttpTransportSE androidHttpTransport = new HttpTransportSE("http://azenethrojas-001-site1.btempurl.com/WSRestaurante.asmx");
            androidHttpTransport.call(SOAP_ACTION, envelope);

            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            Gson gson = new Gson();
            lstMesa = gson.fromJson(response.toString(), typeLst);
        }
        catch(IOException | XmlPullParserException | JsonParseException ex)
        {
            ex.toString();
        }

        return lstMesa;

    }
    public int consultarNumMaxPersonas()
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "consultarMaxPersonas";
        SoapObject request = new SoapObject("ConDelantal", "consultarMaxPersonas");
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
    public int insertarReservacion(int cant_personas, String hora, String fecha, String area, boolean finalizado, int idCliente, int idMesa)
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "guardarReservacion";
        SoapObject request = new SoapObject("ConDelantal", "guardarReservacion");
        request.addProperty("cant_personas",cant_personas);
        request.addProperty("hora",hora);
        request.addProperty("fecha",fecha);
        request.addProperty("area",area);
        request.addProperty("finalizado",finalizado);
        request.addProperty("idCliente",idCliente);
        request.addProperty("idMesa",idMesa);
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
    public int insertarPedido(int subtotal,boolean pagado,int idCliente ,int idReservacion)
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "insertarPedido";
        SoapObject request = new SoapObject("ConDelantal", "insertarPedido");
        request.addProperty("subtotal",subtotal);
        request.addProperty("pagado",pagado);
        request.addProperty("idCliente",idCliente);
        request.addProperty("idReservacion",idReservacion);
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
    public int insertarConsumo(int numplatillos,int idMesa, int idPedido)
    {
        Type type= new TypeToken<String>(){}.getType();
        String SOAP_ACTION = "ConDelantal" + "/" + "insertarConsumo";
        SoapObject request = new SoapObject("ConDelantal", "insertarConsumo");
        request.addProperty("numplatillos",numplatillos);
        request.addProperty("idMesa",idMesa);
        request.addProperty("idPedido",idPedido);
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
