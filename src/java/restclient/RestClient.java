package restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import entity.Teacher;

public class RestClient {

    Client client = ClientBuilder.newClient();
    WebTarget target = client.target("http://localhost:8080/TeacherRestService/webresources/entity.teacher");

    public void createTeacher(Teacher t) {
        target.request().post(Entity.json(t));
    }

    public void updateTeacher(Teacher t) {
        target.request().put(Entity.json(t));
    }

    public Teacher[] getAllTeachers() {

        return target.request().get(Teacher[].class);
    }

    public void delete(String id) {
        target.path(id).request().delete();
    }

    public Teacher getTeacher(String id) {
        return target.path(id).request().get(Teacher.class);

    }

}
