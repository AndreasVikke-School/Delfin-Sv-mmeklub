package delfin.data;

import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.DomainObject;
import delfin.logic.Member;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin Frederiksen & Andreas Vike
 */
public class DataAccessorMemberFile implements DataAccessor {

    @Override
    public List<DomainObject> getAll() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ShowMembers.txt"));
            List<DomainObject> members = new ArrayList();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split(";");
                members.add(new Member(lineSplit[0], lineSplit[2], lineSplit[3], lineSplit[4], new ActivityInfo(StatusEnum.values()[Integer.parseInt(lineSplit[5])], TeamEnum.values()[Integer.parseInt(lineSplit[5])], ActivityEnum.values()[Integer.parseInt(lineSplit[5])])));

            }
            reader.close();
            return members;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("File not found!");
        }
    }

    @Override
    public List<DomainObject> getAllById(String id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ShowMembers.txt"));
            List<DomainObject> members = new ArrayList();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split(";");
                if (id.equals(lineSplit[0])) {
                    members.add(new Member(lineSplit[0], lineSplit[2], lineSplit[3], lineSplit[4], new ActivityInfo(StatusEnum.values()[Integer.parseInt(lineSplit[5])], TeamEnum.values()[Integer.parseInt(lineSplit[5])], ActivityEnum.values()[Integer.parseInt(lineSplit[5])])));
                }

            }
            reader.close();
            return members;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("File not found!");
        }
    }

    @Override
    public DomainObject getSingleById(String id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ShowMembers.txt"));
            Member member = null;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split(";");
                if (id.equals(lineSplit[0])) {
                    member = new Member(lineSplit[0], lineSplit[2], lineSplit[3], lineSplit[4], new ActivityInfo(StatusEnum.values()[Integer.parseInt(lineSplit[5])], TeamEnum.values()[Integer.parseInt(lineSplit[5])], ActivityEnum.values()[Integer.parseInt(lineSplit[5])]));
                }
            }
            reader.close();
            return member;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("File not found while reading!");
        }
    }

    @Override
    public void create(DomainObject obj) {
        Member member = (Member) obj;
        try {
            FileWriter fW = new FileWriter("ShowMembers.txt", true);
            fW.write(member.getId() + ";" + member.getSsn() + ";" + member.getName() + ";" + member.getAddress() + ";" + member.getPhone() + ";" + member.getActivityInfo().getStatus().ordinal() + ";" + member.getActivityInfo().getTeam().ordinal() + ";" + member.getActivityInfo().getActivity().ordinal() + "\n");
            fW.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("File not found while writing!");
        }
    }
}
