#!/usr/bin/env python3
import json
import mysql.connector
from mysql.connector import Error

def connect_to_database():
    """连接到MySQL数据库"""
    try:
        connection = mysql.connector.connect(
            host='192.168.99.159',
            port=3306,
            database='cloud_sample',
            user='root',
            password='root'
        )
        if connection.is_connected():
            print("成功连接到MySQL数据库")
            return connection
    except Error as e:
        print(f"连接数据库时出错: {e}")
        return None

def get_table_structure(connection):
    """获取表结构"""
    try:
        cursor = connection.cursor()
        cursor.execute("DESCRIBE manage_device_dictionary")
        columns = cursor.fetchall()
        print("表结构:")
        for column in columns:
            print(f"  {column}")
        cursor.close()
        return columns
    except Error as e:
        print(f"获取表结构时出错: {e}")
        return None

def get_current_data(connection):
    """获取当前表中的数据"""
    try:
        cursor = connection.cursor()
        cursor.execute("SELECT * FROM manage_device_dictionary LIMIT 5")
        rows = cursor.fetchall()
        print("当前表中的数据示例:")
        for row in rows:
            print(f"  {row}")
        cursor.close()
        return rows
    except Error as e:
        print(f"获取当前数据时出错: {e}")
        return None

def load_type_json():
    """加载type.json文件"""
    try:
        with open('/home/jiaheng/repositories/dji_cloud_demo/DJI-Cloud-API-Demo/type.json', 'r', encoding='utf-8') as f:
            data = json.load(f)
        print(f"成功加载type.json，共{len(data)}条记录")
        return data
    except Exception as e:
        print(f"加载type.json时出错: {e}")
        return None

def main():
    # 连接数据库
    connection = connect_to_database()
    if not connection:
        return
    
    try:
        # 获取表结构
        table_structure = get_table_structure(connection)
        
        # 获取当前数据示例
        current_data = get_current_data(connection)
        
        # 加载JSON数据
        json_data = load_type_json()
        if json_data:
            print(f"\nJSON数据示例:")
            for i, item in enumerate(json_data[:3]):
                print(f"  {i+1}: {item}")
        
    finally:
        if connection.is_connected():
            connection.close()
            print("\n数据库连接已关闭")

if __name__ == "__main__":
    main()
