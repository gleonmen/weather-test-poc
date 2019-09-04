package com.challenge.commons;

import com.challenge.model.ForecastResponse;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ForecastResponseKryoSerializer
        implements StreamSerializer<ForecastResponse> {

    private static final ThreadLocal<Kryo> kryoThreadLocal
            = new ThreadLocal() {

        @Override
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.register(ForecastResponse.class);
            return kryo;
        }
    };

    public ForecastResponseKryoSerializer() {
    }

    public int getTypeId() {
        return 2;
    }

    public void write(ObjectDataOutput objectDataOutput,
                      ForecastResponse customer)
            throws IOException {
        Kryo kryo = kryoThreadLocal.get();
        Output output = new Output((OutputStream) objectDataOutput);
        kryo.writeObject(output, customer);
        output.flush();
    }

    public ForecastResponse read(ObjectDataInput objectDataInput)
            throws IOException {
        InputStream in = (InputStream) objectDataInput;
        Input input = new Input(in);
        Kryo kryo = kryoThreadLocal.get();
        return kryo.readObject(input, ForecastResponse.class);
    }

    public void destroy() {
    }
}