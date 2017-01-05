// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PunterRes.proto

package ru.splat.protobuf;

public final class PunterRes {
  private PunterRes() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PunterOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string resultReason = 1;
    /**
     * <code>required string resultReason = 1;</code>
     */
    boolean hasResultReason();
    /**
     * <code>required string resultReason = 1;</code>
     */
    String getResultReason();
    /**
     * <code>required string resultReason = 1;</code>
     */
    com.google.protobuf.ByteString
        getResultReasonBytes();

    // required int64 transactionID = 2;
    /**
     * <code>required int64 transactionID = 2;</code>
     */
    boolean hasTransactionID();
    /**
     * <code>required int64 transactionID = 2;</code>
     */
    long getTransactionID();

    // optional bool result = 3;
    /**
     * <code>optional bool result = 3;</code>
     */
    boolean hasResult();
    /**
     * <code>optional bool result = 3;</code>
     */
    boolean getResult();
  }
  /**
   * Protobuf type {@code tutorial.Punter}
   */
  public static final class Punter extends
      com.google.protobuf.GeneratedMessage
      implements PunterOrBuilder {
    // Use Punter.newBuilder() to construct.
    private Punter(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Punter(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Punter defaultInstance;
    public static Punter getDefaultInstance() {
      return defaultInstance;
    }

    public Punter getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Punter(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              resultReason_ = input.readBytes();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              transactionID_ = input.readInt64();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              result_ = input.readBool();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return PunterRes.internal_static_tutorial_Punter_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PunterRes.internal_static_tutorial_Punter_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Punter.class, Builder.class);
    }

    public static com.google.protobuf.Parser<Punter> PARSER =
        new com.google.protobuf.AbstractParser<Punter>() {
      public Punter parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Punter(input, extensionRegistry);
      }
    };

    @Override
    public com.google.protobuf.Parser<Punter> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string resultReason = 1;
    public static final int RESULTREASON_FIELD_NUMBER = 1;
    private Object resultReason_;
    /**
     * <code>required string resultReason = 1;</code>
     */
    public boolean hasResultReason() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string resultReason = 1;</code>
     */
    public String getResultReason() {
      Object ref = resultReason_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          resultReason_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string resultReason = 1;</code>
     */
    public com.google.protobuf.ByteString
        getResultReasonBytes() {
      Object ref = resultReason_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        resultReason_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required int64 transactionID = 2;
    public static final int TRANSACTIONID_FIELD_NUMBER = 2;
    private long transactionID_;
    /**
     * <code>required int64 transactionID = 2;</code>
     */
    public boolean hasTransactionID() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required int64 transactionID = 2;</code>
     */
    public long getTransactionID() {
      return transactionID_;
    }

    // optional bool result = 3;
    public static final int RESULT_FIELD_NUMBER = 3;
    private boolean result_;
    /**
     * <code>optional bool result = 3;</code>
     */
    public boolean hasResult() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional bool result = 3;</code>
     */
    public boolean getResult() {
      return result_;
    }

    private void initFields() {
      resultReason_ = "";
      transactionID_ = 0L;
      result_ = false;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasResultReason()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasTransactionID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getResultReasonBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt64(2, transactionID_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBool(3, result_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getResultReasonBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, transactionID_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(3, result_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    protected Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
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
      return PARSER.parseFrom(input);
    }
    public static Punter parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static Punter parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static Punter parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static Punter parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static Punter parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(Punter prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code tutorial.Punter}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements PunterOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return PunterRes.internal_static_tutorial_Punter_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return PunterRes.internal_static_tutorial_Punter_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Punter.class, Builder.class);
      }

      // Construct using ru.splat.protobuf.PunterRes.Punter.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        resultReason_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        transactionID_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        result_ = false;
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return PunterRes.internal_static_tutorial_Punter_descriptor;
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
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.resultReason_ = resultReason_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.transactionID_ = transactionID_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.result_ = result_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
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
        if (other.hasResultReason()) {
          bitField0_ |= 0x00000001;
          resultReason_ = other.resultReason_;
          onChanged();
        }
        if (other.hasTransactionID()) {
          setTransactionID(other.getTransactionID());
        }
        if (other.hasResult()) {
          setResult(other.getResult());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasResultReason()) {
          
          return false;
        }
        if (!hasTransactionID()) {
          
          return false;
        }
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
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string resultReason = 1;
      private Object resultReason_ = "";
      /**
       * <code>required string resultReason = 1;</code>
       */
      public boolean hasResultReason() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string resultReason = 1;</code>
       */
      public String getResultReason() {
        Object ref = resultReason_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          resultReason_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>required string resultReason = 1;</code>
       */
      public com.google.protobuf.ByteString
          getResultReasonBytes() {
        Object ref = resultReason_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          resultReason_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string resultReason = 1;</code>
       */
      public Builder setResultReason(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        resultReason_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string resultReason = 1;</code>
       */
      public Builder clearResultReason() {
        bitField0_ = (bitField0_ & ~0x00000001);
        resultReason_ = getDefaultInstance().getResultReason();
        onChanged();
        return this;
      }
      /**
       * <code>required string resultReason = 1;</code>
       */
      public Builder setResultReasonBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        resultReason_ = value;
        onChanged();
        return this;
      }

      // required int64 transactionID = 2;
      private long transactionID_ ;
      /**
       * <code>required int64 transactionID = 2;</code>
       */
      public boolean hasTransactionID() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required int64 transactionID = 2;</code>
       */
      public long getTransactionID() {
        return transactionID_;
      }
      /**
       * <code>required int64 transactionID = 2;</code>
       */
      public Builder setTransactionID(long value) {
        bitField0_ |= 0x00000002;
        transactionID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 transactionID = 2;</code>
       */
      public Builder clearTransactionID() {
        bitField0_ = (bitField0_ & ~0x00000002);
        transactionID_ = 0L;
        onChanged();
        return this;
      }

      // optional bool result = 3;
      private boolean result_ ;
      /**
       * <code>optional bool result = 3;</code>
       */
      public boolean hasResult() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional bool result = 3;</code>
       */
      public boolean getResult() {
        return result_;
      }
      /**
       * <code>optional bool result = 3;</code>
       */
      public Builder setResult(boolean value) {
        bitField0_ |= 0x00000004;
        result_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool result = 3;</code>
       */
      public Builder clearResult() {
        bitField0_ = (bitField0_ & ~0x00000004);
        result_ = false;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:tutorial.Punter)
    }

    static {
      defaultInstance = new Punter(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:tutorial.Punter)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Punter_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_tutorial_Punter_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\017PunterRes.proto\022\010tutorial\"E\n\006Punter\022\024\n" +
      "\014resultReason\030\001 \002(\t\022\025\n\rtransactionID\030\002 \002" +
      "(\003\022\016\n\006result\030\003 \001(\010B\036\n\021ru.splat.protobufB" +
      "\tPunterRes"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_tutorial_Punter_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_tutorial_Punter_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_tutorial_Punter_descriptor,
              new String[] { "ResultReason", "TransactionID", "Result", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
