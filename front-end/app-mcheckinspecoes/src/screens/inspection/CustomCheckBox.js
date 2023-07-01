import React, { useState } from "react";
import { Text, TouchableOpacity, StyleSheet } from "react-native";
import MaterialIcons from "react-native-vector-icons/MaterialIcons";

const CustomCheckBox = ({ label, checked, onChange }) => {
  const handleToggle = () => {
    onChange(!checked);
  };

  return (
    <TouchableOpacity style={styles.checkboxContainer} onPress={handleToggle}>
      <MaterialIcons
        name={checked ? "check-box" : "check-box-outline-blank"}
        size={24}
        style={styles.checkboxIcon}
      />
      <Text>{label}</Text>
    </TouchableOpacity>
  );
};

const styles = StyleSheet.create({
  checkboxContainer: {
    flexDirection: "row",
    alignItems: "center",
  },
  checkboxIcon: {
    marginRight: 8,
  },
});

export default CustomCheckBox;
