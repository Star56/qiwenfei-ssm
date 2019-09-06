package com.qiwenfei.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * 2019/7/4
 * sunshine
 */
public class MyKafkaProducer  extends Thread{

    private final KafkaProducer<Integer,String> producer;

    private boolean isAysnc  ;
    private String topic ;

    public MyKafkaProducer(String topic,boolean isAysnc){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.172.128:9092");
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,"MyKafkaProducer");
        properties.put(ProducerConfig.ACKS_CONFIG,"-1");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<Integer, String>(properties);

        this.topic=topic;
        this.isAysnc=isAysnc;
    }

    @Override
    public void run() {
        int num=0;
        while (true){
            String message="message_"+num;
            System.out.println("begin send message:"+message);

            producer.send(new ProducerRecord<Integer, String>(topic, message), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(recordMetadata!=null){
                        System.out.println("async-offset:"+recordMetadata.offset()+
                                "->partition"+recordMetadata.partition());
                    }
                }
            });
          num++ ;
        }
    }

    public static void main(String[] args) {
        new MyKafkaProducer("my-kafka",true).start();
    }
}
