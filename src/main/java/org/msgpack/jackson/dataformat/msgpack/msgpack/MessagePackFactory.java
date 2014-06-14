package org.msgpack.jackson.dataformat.msgpack.msgpack;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.IOContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MessagePackFactory extends JsonFactory {
    protected int messagePackGeneratorFeature = 0;
    protected int messagePackParserFeature = 0;

    @Override
    public JsonGenerator createGenerator(OutputStream out, JsonEncoding enc) throws IOException {
        IOContext ioContext = _createContext(out, false);
        return new MessagePackGenerator(messagePackGeneratorFeature, _objectCodec, out);
    }

    @Override
    public JsonParser createParser(InputStream in) throws IOException, JsonParseException {
        IOContext ioContext = _createContext(in, false);
        return _createParser(in, ioContext);
    }

    @Override
    protected MessagePackParser _createParser(InputStream in, IOContext ctxt) throws IOException {
        return new MessagePackParser(ctxt, messagePackParserFeature, in);
    }

}
