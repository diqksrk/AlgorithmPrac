import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {

    public class ParkingInfo {
        private LocalDateTime recentInParkingTime;
        private LocalDateTime recentOutParkingTime;
        private int parkingTime = 0;
        private int totalFee;
    }

    public void setParkingInfo(String[] recordDatail, HashMap<String, ParkingInfo> parkingInfoMap) {
        String parkingTime = recordDatail[0];
        String carNumber   = recordDatail[1];
        String carStatusInfo = recordDatail[2];
        StringBuffer parkingDateTime = new StringBuffer();

        parkingDateTime.append(LocalDate.now());
        parkingDateTime.append(parkingTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");
        ParkingInfo parkingInfo = parkingInfoMap.containsKey(carNumber) ? parkingInfoMap.get(carNumber) : new ParkingInfo();
        if ("IN".equals(carStatusInfo)) {
            parkingInfo.recentInParkingTime = LocalDateTime.parse(parkingDateTime, formatter);
            parkingInfo.recentOutParkingTime = null;
            parkingInfoMap.put(carNumber, parkingInfo);
        } else {
            ParkingInfo parkingInfo1 = parkingInfoMap.get(carNumber);
            parkingInfo1.recentOutParkingTime = LocalDateTime.parse(parkingDateTime, formatter);
            Duration duration = Duration.between(parkingInfo1.recentInParkingTime, parkingInfo1.recentOutParkingTime);
            parkingInfo1.parkingTime = parkingInfo1.parkingTime + (int) duration.getSeconds() / 60;
        }
    }

    public void calcalateFee(HashMap<String, ParkingInfo> parkingInfoMap, int[] fees) {
        for (Map.Entry<String, ParkingInfo> parkingInfoEntry : parkingInfoMap.entrySet()) {
            ParkingInfo parkingInfo = parkingInfoEntry.getValue();
            int standardTime = fees[0];
            int standardFee  = fees[1];
            int addFeeStandardTime = fees[2];
            int addFee       = fees[3];

            if (parkingInfo.recentOutParkingTime == null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm");
                StringBuffer toDayEndTime = new StringBuffer();

                toDayEndTime.append(LocalDate.now());
                toDayEndTime.append("23:59");

                ParkingInfo parkingInfo1 = parkingInfoMap.get(parkingInfoEntry.getKey());
                parkingInfo1.recentOutParkingTime = LocalDateTime.parse(toDayEndTime, formatter);
                Duration duration = Duration.between(parkingInfo1.recentInParkingTime, parkingInfo1.recentOutParkingTime);
                parkingInfo1.parkingTime = parkingInfo1.parkingTime + (int) duration.getSeconds() / 60;
            }

            parkingInfo.totalFee = standardFee;
            if (parkingInfo.parkingTime > standardTime) {
                double addTime = parkingInfo.parkingTime - standardTime;
                int addFeeStand = (int) Math.ceil(addTime / addFeeStandardTime);
                parkingInfo.totalFee += addFeeStand*addFee;
            }
        }
    }
    
    public int[] sortCarNumber(HashMap<String, ParkingInfo> parkingInfoMap) {
        int[] answer = new int[parkingInfoMap.size()];
        int[] dd = parkingInfoMap.keySet().stream().mapToInt(x -> Integer.parseInt(x)).toArray();
        Arrays.sort(dd);
        
        for (int i = 0; i < dd.length; i++) {
            String s = String.format("%4s", String.valueOf(dd[i]));
            s = s.replaceAll(" ", "0");

            answer[i] = parkingInfoMap.get(s).totalFee;
        }
        
        return answer;
    }

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, ParkingInfo> parkingInfoMap = new HashMap<>();
        
        for (String record : records) {
            String[] recordDatail = record.split(" ");

            setParkingInfo(recordDatail, parkingInfoMap);
        }

        calcalateFee(parkingInfoMap, fees);
        
        return sortCarNumber(parkingInfoMap);
    }
}
