// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PunterRequest.proto

package ru.splat.messages;

public final class PunterRequest {
  private PunterRequest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PunterOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Punter)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int32 punter_id = 1;</code>
     */
    int getPunterId();

    /**
     * <code>optional int32 local_task = 2;</code>
     */
    int getLocalTask();

    /**
     * <code>optional string services = 3;</code>
     */
    String getServices();
    /**
     * <code>optional string services = 3;</code>
     */
    com.google.protobuf.ByteString
        getServicesBytes();
  }
  /**
   * Protobuf type {@code Punter}
   */
  public  static final class Punter extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Punter)
      PunterOrBuilder {
    // Use Punter.newBuilder() to construct.
    private Punter(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Punter() {
      punterId_ = 0;
      localTask_ = 0;
      services_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Punter(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              punterId_ = input.readInt32();
              break;
            }
            case 16: {

              localTask_ = input.readInt32();
              break;
            }
            case 26: {
              String s = input.readStringRequireUtf8();

              services_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return PunterRequest.internal_static_Punter_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PunterRequest.internal_static_Punter_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Punter.class, Builder.class);
    }

    public static final int PUNTER_ID_FIELD_NUMBER = 1;
    private int punterId_;
    /**
     * <code>optional int32 punter_id = 1;</code>
     */
    public int getPunterId() {
      return punterId_;
    }

    public static final int LOCAL_TASK_FIELD_NUMBER = 2;
    private int localTask_;
    /**
     * <code>optional int32 local_task = 2;</code>
     */
    public int getLocalTask() {
      return localTask_;
    }

    public static final int SERVICES_FIELD_NUMBER = 3;
    private volatile Object services_;
    /**
     * <code>optional string services = 3;</code>
     */
    public String getServices() {
      Object ref = services_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        services_ = s;
        return s;
      }
    }
    /**
     * <code>optional string services = 3;</code>
     */
    public com.google.protobuf.ByteString
        getServicesBytes() {
      Object ref = services_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        services_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (punterId_ != 0) {
        output.writeInt32(1, punterId_);
      }
      if (localTask_ != 0) {
        output.writeInt32(2, localTask_);
      }
      if (!getServicesBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, services_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (punterId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, punterId_);
      }
      if (localTask_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, localTask_);
      }
      if (!getServicesBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, services_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Punter)) {
        return super.equals(obj);
      }
      Punter other = (Punter) obj;

      boolean result = true;
      result = result && (getPunterId()
          == other.getPunterId());
      result = result && (getLocalTask()
          == other.getLocalTask());
      result = result && getServices()
          .equals(other.getServices());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + PUNTER_ID_FIELD_NUMBER;
      hash = (53 * hash) + getPunterId();
      hash = (37 * hash) + LOCAL_TASK_FIELD_NUMBER;
      hash = (53 * hash) + getLocalTask();
      hash = (37 * hash) + SERVICES_FIELD_NUMBER;
      hash = (53 * hash) + getServices().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Punter parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Punter parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Punter parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Punter parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Punter parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Punter parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Punter parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Punter parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Punter parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Punter parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Punter prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Punter}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Punter)
        PunterOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return PunterRequest.internal_static_Punter_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return PunterRequest.internal_static_Punter_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Punter.class, Builder.class);
      }

      // Construct using ru.splat.messages.PunterRequest.Punter.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        punterId_ = 0;

        localTask_ = 0;

        services_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return PunterRequest.internal_static_Punter_descriptor;
      }

      public Punter getDefaultInstanceForType() {
        return Punter.getDefaultInstance();
      }

      public Punter build() {
        Punter result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Punter buildPartial() {
        Punter result = new Punter(this);
        result.punterId_ = punterId_;
        result.localTask_ = localTask_;
        result.services_ = services_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Punter) {
          return mergeFrom((Punter)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Punter other) {
        if (other == Punter.getDefaultInstance()) return this;
        if (other.getPunterId() != 0) {
          setPunterId(other.getPunterId());
        }
        if (other.getLocalTask() != 0) {
          setLocalTask(other.getLocalTask());
        }
        if (!other.getServices().isEmpty()) {
          services_ = other.services_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Punter parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Punter) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int punterId_ ;
      /**
       * <code>optional int32 punter_id = 1;</code>
       */
      public int getPunterId() {
        return punterId_;
      }
      /**
       * <code>optional int32 punter_id = 1;</code>
       */
      public Builder setPunterId(int value) {
        
        punterId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 punter_id = 1;</code>
       */
      public Builder clearPunterId() {
        
        punterId_ = 0;
        onChanged();
        return this;
      }

      private int localTask_ ;
      /**
       * <code>optional int32 local_task = 2;</code>
       */
      public int getLocalTask() {
        return localTask_;
      }
      /**
       * <code>optional int32 local_task = 2;</code>
       */
      public Builder setLocalTask(int value) {
        
        localTask_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 local_task = 2;</code>
       */
      public Builder clearLocalTask() {
        
        localTask_ = 0;
        onChanged();
        return this;
      }

      private Object services_ = "";
      /**
       * <code>optional string services = 3;</code>
       */
      public String getServices() {
        Object ref = services_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          services_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string services = 3;</code>
       */
      public com.google.protobuf.ByteString
          getServicesBytes() {
        Object ref = services_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          services_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string services = 3;</code>
       */
      public Builder setServices(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        services_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string services = 3;</code>
       */
      public Builder clearServices() {
        
        services_ = getDefaultInstance().getServices();
        onChanged();
        return this;
      }
      /**
       * <code>optional string services = 3;</code>
       */
      public Builder setServicesBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        services_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Punter)
    }

    // @@protoc_insertion_point(class_scope:Punter)
    private static final Punter DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Punter();
    }

    public static Punter getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Punter>
        PARSER = new com.google.protobuf.AbstractParser<Punter>() {
      public Punter parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Punter(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Punter> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Punter> getParserForType() {
      return PARSER;
    }

    public Punter getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Punter_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Punter_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\023PunterRequest.proto\"A\n\006Punter\022\021\n\tpunte" +
      "r_id\030\001 \001(\005\022\022\n\nlocal_task\030\002 \001(\005\022\020\n\010servic" +
      "es\030\003 \001(\tB\"\n\021ru.splat.messagesB\rPunterReq" +
      "uestb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Punter_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Punter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Punter_descriptor,
        new String[] { "PunterId", "LocalTask", "Services", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
