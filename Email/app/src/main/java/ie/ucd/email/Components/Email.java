package ie.ucd.email.Components;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JCantwell on 02/17/2015.
 */
public class Email implements Parcelable {

    private String _from;
    private String _to;
    private String _cc;
    private String _bcc;
    private String _subject;
    private String _body;

    public Email(String to, String from, String cc, String bcc, String subject, String body){
        this._to = to;
        this._from = from;
        this._cc = cc;
        this._bcc = bcc;
        this._subject = subject;
        this._body = body;
    }

    public Email(Parcel source){
        this.set_to(source.readString());
        this.set_from(source.readString());
        this.set_cc(source.readString());
        this.set_bcc(source.readString());
        this.set_subject(source.readString());
        this.set_body(source.readString());
    }


    public String get_subject() {
        return _subject;
    }

    public void set_subject(String _subject) {
        this._subject = _subject;
    }

    public String get_body() {
        return _body;
    }

    public void set_body(String _body) {
        this._body = _body;
    }

    public String get_from() {
        return _from;
    }

    public void set_from(String _from) {
        this._from = _from;
    }

    public String get_to() {
        return _to;
    }

    public void set_to(String _to) {
        this._to = _to;
    }

    public String get_cc() {
        return _cc;
    }

    public void set_cc(String _cc) {
        this._cc = _cc;
    }

    public String get_bcc() {
        return _bcc;
    }

    public void set_bcc(String _bcc) {
        this._bcc = _bcc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.get_from());
        dest.writeString(this.get_to());
        dest.writeString(this.get_cc());
        dest.writeString(this.get_bcc());
        dest.writeString(this.get_subject());
        dest.writeString(this.get_body());
    }

    public static final Parcelable.Creator<Email> CREATOR = new Parcelable.Creator<Email>() {
        public Email createFromParcel(Parcel in){
            return new Email(in);
        }

        @Override
        public Email[] newArray(int size) {
            return new Email[size];
        }
    };
}
