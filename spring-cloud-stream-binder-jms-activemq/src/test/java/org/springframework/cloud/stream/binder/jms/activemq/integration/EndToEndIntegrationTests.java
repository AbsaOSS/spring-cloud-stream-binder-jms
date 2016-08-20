package org.springframework.cloud.stream.binder.jms.activemq.integration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Ignore;
import org.springframework.cloud.stream.binder.jms.activemq.ActiveMQQueueProvisioner;
import org.springframework.cloud.stream.binder.jms.test.ActiveMQTestUtils;

/**
 * @author José Carlos Valero
 * @since 1.1
 */
@Ignore("This is a work in progress")
public class EndToEndIntegrationTests extends org.springframework.cloud.stream.binder.test.integration.EndToEndIntegrationTests {
    private static ActiveMQConnectionFactory connectionFactory;

    static {
        try {
            connectionFactory = ActiveMQTestUtils.startEmbeddedActiveMQServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EndToEndIntegrationTests() throws Exception {
        super(
                new ActiveMQQueueProvisioner(connectionFactory),
                connectionFactory
        );
    }

    @Override
    protected void deprovisionDLQ() throws Exception {
//        TODO: not implemented yet;
    }
}