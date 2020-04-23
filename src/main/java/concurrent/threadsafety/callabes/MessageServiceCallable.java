package concurrent.threadsafety.callabes;

import concurrent.threadsafety.services.MessageService;

import java.util.concurrent.Callable;

public class MessageServiceCallable implements Callable<String> {

    private final MessageService messageService;

    public MessageServiceCallable(MessageService messageService){
        this.messageService = messageService;
    }

    @Override
    public String call() throws Exception {
        return messageService.getMessage();
    }
}
