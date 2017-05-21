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
    @IBOutlet weak var createEditButton: UIButton!
    @IBOutlet weak var addLocationButtonView: UIView!
    
    fileprivate var _picker = UIPickerView()
    
    // MARK: - Public properties -
    
    var presenter: RescueActionPresenterInterface!
    
    // MARK: - Lifecycle -
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.viewDidLoad()
        title = "Rescue action"
        _setupPicker()
        
        actionNameField.delegate = self
        descriptionField.delegate = self
        
        mapView.delegate = self
        mapView.isUserInteractionEnabled = false
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        presenter.viewWillAppear(animated: animated)
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
        mapView.isUserInteractionEnabled = !mapView.isUserInteractionEnabled
    }
    
    @IBAction func pursuitSwitchAction(_ sender: UISwitch) {
        presenter.updateAction(pursuit: sender.isOn)
    }
    
    @IBAction func didSelectRescueAction(_ sender: Any) {
    }
    
    @IBAction func didSelectCreateAction(_ sender: Any) {
        presenter.didSelectCreateAction()
    }
    
    fileprivate func _setupMap(with coordinates: CLLocationCoordinate2D) {
        let camera = GMSCameraPosition.camera(withLatitude: coordinates.latitude, longitude: coordinates.longitude, zoom: 14)
        let mapView = GMSMapView.map(withFrame: .zero, camera: camera)
        self.mapView = mapView
    }
}

// MARK: - Extensions -

extension RescueActionViewController: RescueActionViewInterface {
    
    func setupButton(with title: String) {
        createEditButton.setTitle(title, for: .normal)
    }
    
    func setupNavigationBar() {
        let closeImage = UIImage.fontAwesomeIcon(name: .close, textColor: UIColor.flatWhite, size: CGSize(width: 32, height: 32))
        navigationItem.leftBarButtonItem = UIBarButtonItem(image: closeImage, style: .plain, target: self, action: #selector(didSelectCloseAction))
    }
    
    func setupView(with action: RescueAction) {
        addLocationButtonView.isHidden = true
        actionNameField.text = action.name
        descriptionField.text = action.actionDescription
        pursuitSwitch.isOn = action.pursuit == 1
        rescueTypeField.text = action.rescueType
        
        if let _latitude = action.latitude, let _longitude = action.longitude {
            let marker = GMSMarker()
            marker.position = CLLocationCoordinate2D(latitude: _latitude, longitude: _longitude)
            marker.title = action.name ?? "Action position"
            marker.map = self.mapView
            _setupMap(with: marker.position)
        }
    }
}

extension RescueActionViewController: UITextFieldDelegate {
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        if textField == actionNameField {
            presenter.updateAction(name: actionNameField.text)
        } else if textField == descriptionField {
            presenter.updateAction(descriptionText: descriptionField.text)
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

extension RescueActionViewController: GMSMapViewDelegate {
    
    func mapView(_ mapView: GMSMapView, didTapAt coordinate: CLLocationCoordinate2D) {
        mapView.clear()
        let marker = GMSMarker()
        marker.position = CLLocationCoordinate2D(latitude: coordinate.latitude, longitude: coordinate.longitude)
        marker.title = "Action position"
        marker.map = self.mapView
        
    }
}
