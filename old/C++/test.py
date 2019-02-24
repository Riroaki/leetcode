# -*-coding:utf-8-*-
import csv
import json

# 该代码由我与组员孔小姐讨论完成，分工没有明确界限


def json_to_csv(path):
    with open(path + '.json', "r") as f:
        data = f.read()
    jsonData = json.loads(data)  # 这部分为止是读取json文件

    for people in jsonData[:]:  # 先修改已读的json数据
        reg = people['registered']
        y = reg[0:4]
        m1 = reg[5:7]
        d = reg[8:10]
        h = reg[11:13]
        m2 = reg[14:16]
        s = reg[17:19]
        people[
            'registered'] = d + '/' + m1 + '/' + y + ' ' + h + '.' + m2 + '.' + s  # 这一部分是修改时间

        guid = people['guid']
        people['guid'] = guid.replace('7', '')  # 这一部分是去掉7

    csvfile = open(path + ".csv", "w", newline='')  # 再转化为csv文件
    keys_write = True
    writer = csv.writer(csvfile)
    print(jsonData)
    for dic in jsonData:
        if keys_write:
            keys = list(dic.keys())
            print(keys)
            writer.writerow(keys)
            keys_write = False
        writer.writerow(list(dic.values()))
        print(list(dic.values()))
    csvfile.close()  # 基本操作，百度即可


if __name__ == "__main__":
    path = "./practice"  # 输入你的文件的路径，要先建立同名的.csv文件并放置于一个文件夹内
    json_to_csv(path)
