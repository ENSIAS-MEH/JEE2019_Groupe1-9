package entities;

import java.io.Serializable;

public class _choice implements Serializable {
    private Long _id;
    private String _description;
    private String _number_of_voters;
    private Long _id_poll;

    public _choice(String _description, String _number_of_voters, Long _id_poll) {
        this._description = _description;
        this._number_of_voters = _number_of_voters;
        this._id_poll = _id_poll;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public void set_number_of_voters(String _number_of_voters) {
        this._number_of_voters = _number_of_voters;
    }

    public void set_id_poll(Long _id_poll) {
        this._id_poll = _id_poll;
    }

    public Long get_id() {
        return _id;
    }

    public String get_description() {
        return _description;
    }

    public String get_number_of_voters() {
        return _number_of_voters;
    }

    public Long get_id_poll() {
        return _id_poll;
    }
}
