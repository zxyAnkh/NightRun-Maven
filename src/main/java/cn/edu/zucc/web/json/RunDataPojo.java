package cn.edu.zucc.web.json;

/**
 * Created by zxy on 11/19/2016.
 */
public class RunDataPojo {
    private long id;
    private String sno;
    private String name;
    private double meter;
    // unix time stamp
    private long time;
    private long stime;
    private long etime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMeter() {
        return meter;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getStime() {
        return stime;
    }

    public void setStime(long stime) {
        this.stime = stime;
    }

    public long getEtime() {
        return etime;
    }

    public void setEtime(long etime) {
        this.etime = etime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(id);
        sb.append("; sno = ");
        sb.append(sno);
        sb.append("; name = ");
        sb.append(name);
        sb.append("; meter = ");
        sb.append(meter);
        sb.append("; time = ");
        sb.append(time);
        sb.append("; start time = ");
        sb.append(stime);
        sb.append("; end time = ");
        sb.append(etime);
        return sb.toString();
    }
}
