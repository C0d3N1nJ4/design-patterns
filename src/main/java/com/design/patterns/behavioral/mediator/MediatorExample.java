package com.design.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Room coordinates colleagues without requiring direct peer references. */
public final class MediatorExample {
    private MediatorExample() {
    }

    public static final class ChatRoom {
        private final List<Member> members = new ArrayList<>();

        public void join(Member member) {
            Objects.requireNonNull(member, "member");
            if (member.room != null) {
                throw new IllegalStateException("Already joined a room");
            }
            members.add(member);
            member.room = this;
        }

        private void send(Member sender, String message) {
            for (var member : members) {
                if (member != sender) {
                    member.inbox.add(sender.name + ": " + message);
                }
            }
        }
    }

    public static final class Member {
        private final String name;
        private final List<String> inbox = new ArrayList<>();
        private ChatRoom room;

        public Member(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name must not be blank");
            }
            this.name = name;
        }

        public void say(String message) {
            if (room == null) {
                throw new IllegalStateException("Not in a room");
            }
            if (message == null || message.isBlank()) {
                throw new IllegalArgumentException("message must not be blank");
            }
            room.send(this, message);
        }

        public List<String> inbox() {
            return List.copyOf(inbox);
        }
    }
}
