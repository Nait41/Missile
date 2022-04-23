package Messenger.Missile.service;

import Messenger.Missile.domain.Comment;
import Messenger.Missile.domain.Message;
import Messenger.Missile.domain.User;
import Messenger.Missile.domain.Views;
import Messenger.Missile.dto.EventType;
import Messenger.Missile.dto.ObjectType;
import Messenger.Missile.repo.CommentRepo;
import Messenger.Missile.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);;

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}

