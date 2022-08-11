import java.util.ArrayList;
import java.util.List;

public class Runner {
}

/*
-- DATABASE TABLES ---
Member(int id, String username, AccountType accountType, String password_hash)
questions(int id, int member_id, String title, String body, int question_status_id)
question_status(int id, boolean is_duplicate, boolean has_bounty, int bounty_value)
tags(int id, string tag, int entity_id)
comments(int id, String comment_body, int member_id, int entity_id)
votes(int id, int user_id, int vote, int entity_id)
answers(int id, int member_id, int body, int question_id)
report(int id, String report_reason, int entity_id)
----------------------
 */
enum AccountType {
    MEMBER, ADMIN
}

enum QuestionStatus {
    OPEN, CLOSED, DUPLICATE, HAS_BOUNTY, DELETED
}

class QuestionWithTags {
    String title;
    QuestionStatus questionStatus;
    boolean hasAcceptedSolution;
    List<Tag> Tags;
    int votes;
}

class QuestionAnswers {
    String title;
    String questionBody;
    Member postedBy;
    List<Vote> votes;
    List<Comment> commentList;
    List<Tag> tags;
    AnswerResponse answers;
}

class AnswerResponse {
    List<Answer> answers;
    Pagination pagination;
}

class Pagination {
    int currentPage;
    int currentSize;
    int totalSize;
}

class Answer {
    String body;
    Member postedBy;
    List<Vote> votes;
    List<Comment> commentList;
    List<Tag> tags;
    boolean isAccepted;
    int question_id;
}

class Vote {
    int value;
    Member votedBy;
}

class Member {
    String username;
    AccountType accountType;
    String passwordHash;
}

class Comment {
    String body;
    Member postedBy;
}

class Tag {
    String body; // can be limited
    Member addedBy;
}

class Question {
    String title;
    String body;
    QuestionStatus questionStatus;
    Member postedBy;
}

class Badge {
    String name;
}
//-------------------------

// ----- Service -----

class SearchService {
    List<QuestionWithTags> searchQuestions(String text, List<Tag> tags) { return new ArrayList<>(); }
    List<QuestionWithTags> searchQuestions(String text) { return new ArrayList<>(); }
    List<QuestionWithTags> searchQuestions(List<Tag> tags) { return new ArrayList<>(); }
}

class QuestionService {
    void postQuestion(int memberId, Question question) {};
    void editQuestion(int memberId, Question question) {};
    void deleteQuestion(int memberId, int questionId) {};
    void addBounty(int memberId, int questionId, int bountyScore) {};
    void report(int memberId, int questionId, String reportReason) {};
}

class CommentService {
    void addComment(int memberId, int entityId, int entityType) {};
    void report(int memberId, int commentId, String reportReason) {};
}

class TagService {
    void addTag(int memberId, int entityId, int entityType) {};
}

class VoteService {
    void addVote(int memberId, int entityId, int entityType) {};
}

class AnswerService {
    void postAnswer(int memberId, int questionId, Answer answer) {};
    void markAccepted(int memberId, int answerId) {};
    void report(int memberId, int answerId, String reportReason) {};
}

class UserService {
    void updateInfo() {};
    void resetPassword() {};
    void addBadge(int memberId, Badge badge) {};
}

class AdminService extends UserService {
    void blockAccount(int memberId) {};
}

// ---------------------------------------