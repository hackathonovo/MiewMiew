//
//  RescueActionViewController.swift
//  HGSS
//
//  Created by Nikola Majcen on 20/05/2017.
//  Copyright (c) 2017 Nikola Majcen. All rights reserved.
//

import UIKit
import FontAwesome_swift
import GoogleMaps

final class RescueActionViewController: UIViewController {
    
    
    @IBOutlet weak var mapView: GMSMapView!
    @IBOutlet weak var addLocationButton: UIButton!
    @IBOutlet weak var actionNameField: UITextField!
    @IBOutlet weak var descriptionField: UITextField!
    @IBOutlet weak var pursuitSwitch: UISwitch!
    @IBOutlet weak var rescueTypeButton: UIButton!
    @IBOutlet weak var rescueTypeField: UITextField!
    
    fileprivate var _picker = UIPickerView()
    
    // MARK: - Public properties -
    
    var presenter: RescueActionPresenterInterface!
    
    // MARK: - Lifecycle -
    
    override func viewDidLoad() {
        super.viewDidLoad()
        title = "New rescue action"
        _setupNavigationBar()
        _setupPicker()
    }
    
    fileprivate func _setupNavigationBar() {
        let closeImage = UIImage.fontAwesomeIcon(name: .close, textColor: UIColor.flatWhite, size: CGSize(width: 32, height: 32))
        navigationItem.leftBarButtonItem = UIBarButtonItem(image: closeImage, style: .plain, target: self, action: #selector(didSelectCloseAction))
    }
    
    fileprivate func _setupPicker() {
        _picker.delegate = self
        _picker.dataSource = self
        
        let toolbar = UIToolbar(frame: CGRect(x: 0, y: 0, width: view.frame.width, height: 44))
        let flexSpace = UIBarButtonItem(barButtonSystemItem: .flexibleSpace, target: nil, action: nil)
        let doneButton = UIBarButtonItem(title: "Done", style: .plain, target: self, action: #selector(didSelectRescueType))
        toolbar.items = [flexSpace, doneButton]
        
        rescueTypeField.inputAccessoryView = toolbar
        rescueTypeField.inputView = _picker
    }
    
    func didSelectRescueType() {
        rescueTypeField.resignFirstResponder()
    }
    
    func didSelectCloseAction() {
        presenter.didSelectCloseAction()
    }
    
    // MARK: - Actions
    
    @IBAction func didSelectAddLocation(_ sender: Any) {
    }
    
    @IBAction func pursuitSwitchAction(_ sender: UISwitch) {
        presenter.updateAction(pursuit: sender.isOn)
    }
    
    @IBAction func didSelectRescueAction(_ sender: Any) {
    }
    
    @IBAction func didSelectCreateAction(_ sender: Any) {
    }
    
    fileprivate func _showPicker() {
    }
}

// MARK: - Extensions -

extension RescueActionViewController: RescueActionViewInterface {
}


extension RescueActionViewController: TabBarItemSetupable {
    
    func setupTabBarItem() {
        tabBarItem.image = UIImage.fontAwesomeIcon(name: .map, textColor: UIColor.blue, size: CGSize(width: 32, height: 32))
        tabBarItem.selectedImage = UIImage.fontAwesomeIcon(name: .map, textColor: UIColor.blue, size: CGSize(width: 32, height: 32))
        tabBarItem.title = "Rescue"
    }
}

extension RescueActionViewController: UITextFieldDelegate {
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        if textField == actionNameField {
            if let _text = actionNameField.text, _text.isEmpty {
                actionNameField.backgroundColor = UIColor.flatRed
            } else {
                presenter.updateAction(name: actionNameField.text)
            }
        }
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        if actionNameField == textField {
            descriptionField.becomeFirstResponder()
        } else if descriptionField == textField {
            descriptionField.resignFirstResponder()
        }
        return true
    }
}

extension RescueActionViewController: UIPickerViewDelegate, UIPickerViewDataSource {
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return presenter.numberOfPickerItems()
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return presenter.pickerTitleFor(row)
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        rescueTypeField.text = presenter.pickerTitleFor(row)
        presenter.updateAction(rescueType: row)
    }
}
